import { Component,ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Chart } from 'chart.js';
import { RestApiService } from '../../../app/rest-api.service';
import { Subscription } from 'rxjs/Subscription';



/**
 * Generated class for the EstadisticaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-estadistica',
  templateUrl: 'estadistica.html',
  providers:[RestApiService]
})



export class EstadisticaPage {
  private  mostrar :boolean =false;

  private aux: any
    private aux2: any
    respu : any =  {"username":"","label":[],"data":[],"nombre":"","_id":"","_errorCode" :"550","_errorMsg":"No Se puede Cargar la informacion"}
    respu1 : any
    respu2 : any
    respu3 : any
    respu4 : any
    respu5 : any
    respu6 : any
    respu7 : any
    respu8 : any
    respu9 : any

    
    type = 'bar'


  
  @ViewChild('barCanvas') barCanvas;
 @ViewChild('doughnutCanvas') doughnutCanvas;
 @ViewChild('lineCanvas') lineCanvas;

    barChart: Chart;
     doughnutChart: any;
     lineChart: any;

  constructor(public navCtrl: NavController, public navParams: NavParams,
    public api: RestApiService) {
            
       
   

     
  }


  ionViewDidLoad() {
    console.log('ionViewDidLoad EstadisticaPage');
    console.log(this.respu)
    this.pet()
    
    
    
  }



public pet ()
{
    this.api.geta('Estadistica/Estadistica1').subscribe((data) => { // Success
        this.respu1 = data.json()
        console.log (this.respu)
       },
       (error) =>{
        this.respu1 =  this.respu
         console.error(error);
       });


       this.api.geta('Estadistica/Estadistica2').subscribe((data) => { // Success
        this.respu2 = data.json()
        console.log (this.respu)
       },
       (error) =>{
        this.respu2 =  this.respu
         console.error(error);
       });


       this.api.geta('Estadistica/Estadistica3').subscribe((data) => { // Success
        this.respu3 = data.json()
        console.log (this.respu)
       },
       (error) =>{
        this.respu3 =  this.respu
         console.error(error);
       });


       this.api.geta('Estadistica/Estadistica4').subscribe((data) => { // Success
        this.respu4 = data.json()
        console.log (this.respu)
       },
       (error) =>{
        this.respu4 =  this.respu
         console.error(error);
       });


       this.api.geta('Estadistica/Estadistica5').subscribe((data) => { // Success
        this.respu5 = data.json()
        console.log (this.respu)
       },
       (error) =>{
        this.respu5 =  this.respu
         console.error(error);
       });


       this.api.geta('Estadistica/Estadistica6').subscribe((data) => { // Success
        this.respu6 = data.json()
        console.log (this.respu)
       },
       (error) =>{
         console.error(error);
         this.respu6 =  this.respu
       });

    
       this.api.geta('Estadistica/Estadistica7').subscribe((data) => { // Success
        this.respu7 = data.json()
        console.log (this.respu)
       },
       (error) =>{
        this.respu7 =  this.respu
         console.error(error);
       });


       this.api.geta('Estadistica/Estadistica8').subscribe((data) => { // Success
        this.respu8 = data.json()
        console.log (this.respu)
       },
       (error) =>{
        this.respu8 =  this.respu
         console.error(error);
       });

       
       this.api.geta('Estadistica/Estadistica9').subscribe((data) => { // Success
        this.respu9 = data.json()
        console.log (this.respu)
       },
       (error) =>{
        this.respu9 =  this.respu
         console.error(error);
       });

      

}







public metodo (id:any)
{
  
    if (id == 1)
    {
        
       this.mostrar = true;
       this.respu = this.respu1 

    this.CrearGrafica()
    this.respu1 =[]
    }
    else if (id == 2)
    {
     
        this.mostrar = true;
        this.respu = this.respu2 

        this.CrearGrafica()
    }
    else if (id == 3)
    {
     
        this.mostrar = true;
        this.respu = this.respu3 

        this.CrearGrafica()
    }

    else if (id == 4)
    {
     
        this.mostrar = true;
        this.respu = this.respu4 

        this.CrearGrafica()
    }

    else if (id == 5)
    {
     
        this.mostrar = true;
        this.respu = this.respu5 

        this.CrearGrafica()
    }

    else if (id == 6)
    {
     
        this.mostrar = true;
        this.respu = this.respu6 

        this.CrearGrafica()
    }
    else if (id == 7)
    {
     
        this.mostrar = true;
        this.respu = this.respu7 

        this.CrearGrafica()
    }

    else if (id == 8)
    {
     
        this.mostrar = true;
        this.respu = this.respu8 

        this.CrearGrafica()
    }

    else if (id == 9)
    {
     
        this.mostrar = true;
        this.respu = this.respu9 

        this.CrearGrafica()
    }



}

  public   CrearGrafica ()
 {
    if (this.respu._errorCode != 550)
    {
    
  if (this.respu.label != null)
{
    if (this.barChart != null)
    {
         this.barChart.destroy()
    }
    if (this.doughnutChart != null)
    {
         this.doughnutChart.destroy()
    }




   this.barChart = new Chart(this.barCanvas.nativeElement, {

       type: this.type,
       data: {
           labels: this.respu.label,
           datasets: [{
               label: this.respu.nombre,
               data: this.respu.data,
               backgroundColor: [
                   'rgba(255, 99, 132, 0.2)',
                   'rgba(54, 162, 235, 0.2)',
                   'rgba(255, 206, 86, 0.2)',
                   'rgba(75, 192, 192, 0.2)',
                   'rgba(153, 102, 255, 0.2)',
                   'rgba(255, 159, 64, 0.2)'
               ],
               borderColor: [
                   'rgba(255,99,132,1)',
                   'rgba(54, 162, 235, 1)',
                   'rgba(255, 206, 86, 1)',
                   'rgba(75, 192, 192, 1)',
                   'rgba(153, 102, 255, 1)',
                   'rgba(255, 159, 64, 1)'
               ],
               borderWidth: 1
           }]
       },
       options: {
           scales: {
               yAxes: [{
                   ticks: {
                       beginAtZero:true
                   }
               }]
           }
       }

   });


 //
   this.doughnutChart = new Chart(this.doughnutCanvas.nativeElement, {

       type: "doughnut",
       data: {
        labels: this.respu.label,
        datasets: [{
            label: this.respu.nombre,
            data: this.respu.data,
               backgroundColor: [
                   'rgba(255, 99, 132, 0.2)',
                   'rgba(54, 162, 235, 0.2)',
                   'rgba(255, 206, 86, 0.2)',
                   'rgba(75, 192, 192, 0.2)',
                   'rgba(153, 102, 255, 0.2)',
                   'rgba(255, 159, 64, 0.2)'
               ],
               hoverBackgroundColor: [
                   "#FF6384",
                   "#36A2EB",
                   "#FFCE56",
                   "#FF6384",
                   "#36A2EB",
                   "#FFCE56"
               ]
           }]
       }

   });
 
}
 }
 else
{
    alert (this.respu._errorMsg)
}


}





}
