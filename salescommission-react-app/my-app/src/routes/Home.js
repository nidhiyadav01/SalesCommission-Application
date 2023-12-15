import React, { useState, useEffect } from 'react';

function Home() {
      
  const [salesCommissions, setSalesCommissions] = useState([]);
  const [selectedProduct, setSelectedProduct] = useState(null);
  const [selectedSalesman, setSelectedSalesman] = useState(null);
  
  useEffect(() => {
    fetch('http://localhost:8080/getsales/commission')
      .then(response => response.json())
      .then(data => setSalesCommissions(data))
      .catch(error => console.error(error));
  }, []);

  

  const handleProductClick = (salesCommission) => {
    setSelectedProduct(salesCommission);
  }
  const handleSalesmanClick = (salesCommission) => {
    setSelectedSalesman(salesCommission);
  }
  return (
    <div >
      <br></br>
      <h1 ><u>Sales Commission Data</u></h1>
      <br></br>
     
      <table >
        <thead>
          <tr>
            <th>Product</th>
            <th>Salesman Name</th>
            <th>Product Quantity</th>
            <th>Sales Amount</th>
            <th>Salesman Area</th>
            <th>Salesman Commission</th>
          </tr>
        </thead>
        <tbody>
          {salesCommissions.map(salesCommission => (
            <tr key={salesCommission.id}>
           <td onClick={() => handleProductClick(salesCommission)}>
             <a href="#" style={{ textDecoration: 'underline', color: 'black' }}>
             {salesCommission.product}
             </a>
           </td>
           <td onClick={() => handleSalesmanClick(salesCommission)}>
             <a href="#" style={{ textDecoration: 'underline', color: 'black' }}>
             {salesCommission.salesmanName}
             </a>
            </td>
              
              <td>{salesCommission.productQuantity}</td>
              <td>{salesCommission.salesAmount}</td>
              <td>{salesCommission.salesmanArea}</td>
              <td>{salesCommission.salesmanCommission}</td>
            </tr>
          ))}
        </tbody>
      {selectedProduct && (
        <div className="popup">
          <div className="popup-content">
            <h2>{selectedProduct.product}</h2>
            <p>Salesman Area: {selectedProduct.salesmanArea}</p>
            <p>Sales Amount: {selectedProduct.salesAmount}</p>
            <p>Product Quantity: {selectedProduct.productQuantity}</p>
            <button onClick={() => setSelectedProduct(null)}>Close</button>
          </div>
        </div>
      )}
      {selectedSalesman && (
        <div className="popup">
           <div className="popup-content">
            <h2>{selectedSalesman.salesmanName}</h2>
            
            <p>Salesman Area: {selectedSalesman.salesmanArea}</p>
            <p>Sales Amount: {selectedSalesman.salesAmount}</p>
            <p>Product Quantity: {selectedSalesman.productQuantity}</p>
            <button  onClick={() => setSelectedSalesman(null)}>Close</button>
           
          
          </div>
        </div>
      )}
      </table>
      </div>
     

    
  );

  

 
}

export default Home;