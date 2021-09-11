import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { SaleSuccess } from 'types/sale';
import { round } from 'utils/formats';
import { BASE_URL } from 'utils/requests';

const BarChart = () => {

    type ChartData = {
        labels: {
            categories:string[]
        },
        series: [
            {
                name: string,
                data:number[]
            }
        ]
    } 
    
    const [chartData, setChartData] = useState<ChartData>({
        labels:{
            categories:[]
        },
        series:[ 
            {
                name:'',
                data:[]
            }
        ]
    });

    useEffect(()=> {
        axios.get(`${BASE_URL}/sales/SuccessBySaller`)
    
        .then( x => {
            const data = x.data as SaleSuccess[];
            const lstLabels = data.map(x=> x.sellerName);
            const lstSeries = data.map(x=> round((x.deals /x.visited) * 100,1));
            
            setChartData({ 
                labels:{ 
                    categories: lstLabels
                },
                series:[
                    {
                        name:'% Sucesso de Vendas',
                        data:lstSeries
                    }
                ]
             }); 
            
        });
    },[])
     
    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };
    
    
    return (
        <Chart 
        options={{...options, xaxis: chartData.labels }}
        series= {chartData.series}
        type="bar"
        height="240"
        />
    );
}

export default BarChart;

