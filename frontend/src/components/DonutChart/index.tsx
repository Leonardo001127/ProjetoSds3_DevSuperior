import axios from 'axios'
import { useEffect, useState } from 'react'
import Chart from 'react-apexcharts'
import { SaleSum } from 'types/sale'
import { BASE_URL } from 'utils/requests'

type ChartData = {
    labels: string[],
    series: number[]
}

const DonutChart = () => {


    const [chardData, setChardData] = useState<ChartData>({ labels: [], series: [] });

    useEffect(()=> {
        axios.get(`${BASE_URL}/sales/SumBySaller`)
    
        .then( x => {
            const data = x.data as SaleSum[];
            const lstLabels = data.map(x=> x.sellerName);
            const lstSeries = data.map(x=> x.sum);
            
            setChardData({ labels:lstLabels,series:lstSeries }); 
            
        });
    },[])
     

 

   

    const options = {
        legend: {
            show: true
        }
    } 
    return (
        <Chart
            options={{ ...options, labels: chardData.labels }}
            series={ chardData.series }
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;

