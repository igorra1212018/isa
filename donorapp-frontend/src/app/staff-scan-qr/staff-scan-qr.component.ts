import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import  jsQR, { QRCode } from 'jsqr';

@Component({
  selector: 'app-staff-scan-qr',
  templateUrl: './staff-scan-qr.component.html',
  styleUrls: ['../shared-style.css', './staff-scan-qr.component.css']
})
export class StaffScanQrComponent {

  selectedFile!: File;
  base64String!: string;
  public errorMsg = "" as string;
  
  uploadedImage: File | null = null;
  decodedText: string | null = null;

  constructor(private route: ActivatedRoute, private router: Router) { }

  submit() {
    if(this.decodedText && this.decodedText.length > 4){
      let decodedId = "";
      for(var i = 4; i < this.decodedText.length && this.decodedText[i] != '\n'; i++){
        decodedId += this.decodedText[i];
      }
      if(this.isNumber(decodedId))
        this.router.navigate(['staff-start-appointment/' + decodedId]);
      else
        console.log("Couldn't parse.");
    }
  }

  isNumber(value?: string | number): boolean {
    return ((value != null) &&
            (value !== '') &&
            !isNaN(Number(value.toString())));
  }

  handleFileInput(event: any) {
    this.selectedFile = event.target.files[0];

    const reader = new FileReader();
    reader.onload = (e: any) => {
      this.base64String = e.target.result;
    };
    reader.readAsDataURL(this.selectedFile);
  }

  async handleImageUpload(event: any) {
    this.uploadedImage = event.target.files[0];
    const reader = new FileReader();

    reader.onload = (e: any) => {
      const img = new Image();
      img.src = e.target.result;

      img.onload = () => {
        const canvas = document.createElement('canvas');
        const context = canvas.getContext('2d');
        canvas.width = img.width;
        canvas.height = img.height;
        context?.drawImage(img, 0, 0);

        const imageData = context?.getImageData(0, 0, canvas.width, canvas.height);
        if (imageData) {
          const qrCode = jsQR(imageData.data, imageData?.width, imageData?.height);

          if (qrCode) {
            this.decodedText = qrCode.data;
            console.log(this.decodedText);
          } else {
            this.decodedText = 'No QR code found in the image.';
            console.log(this.decodedText);
          }
        }
      };
    };

    if(this.uploadedImage)
      reader.readAsDataURL(this.uploadedImage);
  }
}
