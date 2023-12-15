// import React, { useState } from 'react';

// const MyComponent = () => {
//   const [salesData, setSalesData] = useState(null);

//   const handleFileUpload = (event) => {
   
//     const file = event.target.files[0];
//     const reader = new FileReader();
//     reader.onload = (e) => {
//       const json = JSON.parse(e.target.result);
//       setSalesData(json);
//     };
//     reader.readAsText(file);
//   };

//   const handleSubmit = async () => {
    
//     const response = await fetch('http://localhost:8080/sales', {
//       method: 'POST',
//       headers: {
//         'Content-Type': 'application/json'
//       },
//       body: JSON.stringify(salesData)
//     });
//     const data = await response.json();
//     console.log(data);
//   };

//   return (
//     <div>
//       <input type="file" onChange={handleFileUpload} />
//       <button onClick={handleSubmit}>Submit</button>
//     </div>
//   );
// };

// export default MyComponent;

import React, { useState } from 'react';
import axios from 'axios';

function MyComponent() {
   const [file, setFile] = useState(null);

   const handleFileChange = (event) => {
      setFile(event.target.files[0]);
   }

   const handleSubmit = (event) => {
      event.preventDefault();

      const fileReader = new FileReader();
      fileReader.readAsText(file, "UTF-8");
      fileReader.onload = (e) => {
         const sales = JSON.parse(e.target.result);
         console.log(sales);
         axios.post('http://localhost:8080/sales', sales)
            .then(response => {
               if (response.ok) {
                  alert('Sales added successfully');
                } else {
                  alert('Sales added successfully');
                }
              });
              
            
            
      }
   }

   return (
      <form className='upload-form' onSubmit={handleSubmit}>
         <h2>Upload JSON File</h2>
         <input  class="custom-file-input" type="file" onChange={handleFileChange} />
         <button type="submit"><b>Upload</b></button>
      </form>
   );
}

export default MyComponent;

