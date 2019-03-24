import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent implements OnInit {

  theme = 'dark';

  options = {
    title: {
      text: '饮料销售情况统计',
      subtext: 'Beta',
      x: 'center'
    },
    tooltip: {
      trigger: 'item',
      formatter: '{b} : {c} ({d}%)'
    },
    legend: {
      x: 'center',
      y: 'bottom',
      data: ['珍珠奶茶', '红茶', '绿茶', '西瓜汁']
    },
    calculable: true,
    series: [
      {
        name: 'area',
        type: 'pie',
        radius: [30, 110],
        roseType: 'area',
        data: []
      }
    ]
  };


  interval = setInterval(() => {
      this.service.getViewData().subscribe(
        (res) => {
          this.options.series[0].data = res;
        }
      );
  }, 10000);

  constructor(private service: DataService) {
    service.getViewData().subscribe(
      (res) => {
        this.options.series[0].data = res;
      }
    );
  }


  ngOnInit() {
  }

}
