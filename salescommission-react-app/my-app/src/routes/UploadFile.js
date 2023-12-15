
import { AiFillFileAdd} from "react-icons/ai";

import '../SalesCommissions.css';

import FileUpload from "../FileUpload";

function UploadFile() {
  

  
  return (
    <div >
      <br></br>
      <h1>Upload Sales Commission File<AiFillFileAdd className="page-icon" /></h1>
     
      <br></br>
    <FileUpload/>
    </div>
  );
}

export default UploadFile;