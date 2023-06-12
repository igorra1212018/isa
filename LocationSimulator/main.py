import math

import folium
from folium import plugins
import osmnx as ox
import networkx as nx

from flask import Flask, request
import json
import time

import pika
import json

ox.settings.log_console = True
ox.settings.use_cache = True

# start_latlng = (45.23954, 19.80781)
# end_latlng = (45.25232, 19.82115)


def execute_pathfind(start_latlng, end_latlng):
    place = 'Novi Sad, Serbia'
    mode = 'drive'  # 'drive', 'bike', 'walk'
    optimizer = 'time'  # 'length','time'
    graph = ox.graph_from_place(place, network_type=mode, simplify=False)

    orig_node = ox.distance.nearest_nodes(graph, start_latlng[1],
                                          start_latlng[0])

    dest_node = ox.distance.nearest_nodes(graph, end_latlng[1],
                                          end_latlng[0])

    shortest_route = nx.shortest_path(graph,
                                      orig_node,
                                      dest_node,
                                      weight=optimizer)

    print(shortest_route)
    print(graph)

    shortest_route_map = ox.plot_route_folium(graph, shortest_route)

    nodes, edges = ox.graph_to_gdfs(graph)

    route_nodes = [(nodes.loc[node]['y'], nodes.loc[node]['x']) for node in shortest_route]
    print(route_nodes)

    shortest_route_map.save('shortest_route_map.html')
    return route_nodes


def distance(start_node, end_node):
    return math.sqrt(math.pow(start_node[0] - end_node[0], 2) + math.pow(start_node[1] - end_node[1], 2))


def simulate_car(route_nodes):
    car_spd = 30 * 0.00001
    total_len = 0
    len_progress = 0

    delta_time = 0.2
    distances = []

    for i in range(len(route_nodes) - 1):
        start_node = route_nodes[i]
        end_node = route_nodes[i + 1]
        dist = distance(start_node, end_node)
        distances.append(dist)
        total_len += dist

    current_index = 0
    dist_accumulation = 0

    car_dist = car_spd * delta_time

    while len_progress < total_len:
        len_progress += car_dist
        while current_index < len(distances) - 1 and dist_accumulation + distances[current_index] < len_progress:
            dist_accumulation += distances[current_index]
            current_index += 1
        edge_progress = max(min((len_progress - dist_accumulation) / distances[current_index], 1), 0)
        print(current_index, ": ", edge_progress)
        if current_index < len(distances):
            start_node = route_nodes[current_index]
            end_node = route_nodes[current_index + 1]
            lat = start_node[0] + (end_node[0] - start_node[0]) * edge_progress
            long = start_node[1] + (end_node[1] - start_node[1]) * edge_progress

            message = str(str(lat)) + ',' + str(long)

            channel.basic_publish(exchange='spring-boot-exchange', routing_key='hello', body=message.encode('utf-8'))
            print(f" [x] Sent '{message}'")

        time.sleep(delta_time)


app = Flask(__name__)
connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
channel = connection.channel()

channel.queue_declare(queue='hello')


@app.route('/endpoint', methods=['POST'])
def handle_post():
    connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
    channel = connection.channel()
    channel.queue_declare(queue='hello')

    data = request.get_json()
    print(json.dumps(data, indent=4))
    start_latlng = (data["start_latitude"], data["start_longitude"])
    end_latlng = (data["end_latitude"], data["end_longitude"])
    route_nodes = execute_pathfind(start_latlng, end_latlng)
    simulate_car(route_nodes)

    connection.close()
    return 'Message received'  # Return a response to the client


obj = {
    'latitude': 45.24365,
    'longitude': 19.83517
}


if __name__ == '__main__':

    #message = str(obj['latitude']) + ',' + str(obj['longitude'])

    #channel.basic_publish(exchange='spring-boot-exchange', routing_key='hello', body=message.encode('utf-8'))
    #print(" [x] Sent 'Hello World!'")
    app.run()

