import axios from 'axios'
import Chart from 'react-apexcharts'
import { SaleSum } from 'types/sale'
import { BASE_URL } from 'utils/requests'

type ChartData = {
    labels: string[],
    series: number[]
}

const DonutChart = () => {

    var chardData: ChartData = { labels: [], series: [] }

 

    axios.get(`${BASE_URL}/sales/SumBySaller`)
    
    .then( x => {
        const data = x.data as SaleSum[];
        const lstLabels = data.map(x=> x.sellerName);
        const lstSeries = data.map(x=> x.sum);
        
        chardData = { labels:lstLabels,series:lstSeries }; 
        console.log(chardData)
        //console.log(x.data);
    });

    const options = {
        legend: {
            show: true
        }
    } 
    return (
        <Chart
            options={{ ...options, labels: chardData.labels }}
            series={chardData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;

