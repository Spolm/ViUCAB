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
  private perra = ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"]
  private perra4 =["rivetti", "es", "rolo", "de ", "pargo", "si","burda "]
  private perra2 = [12, 19, 3, 5, 2, 3]
  private perra3 = [10, 5, 2, 3, 2, 1]
  private aux: any
    private aux2: any
    respu : any
    respu1 : any

    
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
    this.pet()
  }



public pet ()
{
    this.api.geta('Estadistica/Estadistica1').subscribe((data) => { // Success
        this.respu = data.json()
        console.log (this.respu)
       },
       (error) =>{
         console.error(error);
       });

}






public metodo (id:any)
{
  
    if (id == 1)
    {
        
       this.mostrar = true;
       this.respu1 = this.respu 

    this.CrearGrafica()
    this.respu1 =[]
    }
    else if (id == 2)
    {
     
       
        this.mostrar = true;
        this.respu1.label = this.perra4
        this.respu1.data = this.perra2
   
        this.CrearGrafica()
    }


}

  public   CrearGrafica ()
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
           labels: this.respu1.label,
           datasets: [{
               label: '# of Votes',
               data: this.respu1.data,
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
        labels: this.respu1.label,
        datasets: [{
            label: '# of Votes',
            data: this.respu1.data,
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
