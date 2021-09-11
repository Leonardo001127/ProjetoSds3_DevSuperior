import axios from "axios";
import { useState, useEffect } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/formats";
import { BASE_URL } from "utils/requests";

const DataTable = () => {

    const[page, setPage] = useState<SalePage>({
        first:true,
        number:0,
        totalElements:0,
        totalPages:0,
        last:true,
        page:0
      });
      
      useEffect(()=> {
        axios.get(`${BASE_URL}/sales?page=1&size=15`)
    
        .then( x => {
            setPage(x.data); 
          });
      },[])


    return (
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Vendedor</th>
                        <th>Clientes visitados</th>
                        <th>Negócios fechados</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    {page.content?.map( item => (
                            <tr key={item.id}>
                                <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                                <td>{item.seller.sellerName}</td>
                                <td>{item.visited}</td>
                                <td>{item.deals}</td>
                                <td>{item.amount}</td>
                            </tr>
                        ))}
                     
                    
                </tbody>
            </table>
        </div>
    );
}

export default DataTable;