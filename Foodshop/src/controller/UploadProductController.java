package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ProductDao;

/**
 * Servlet implementation class UploadProduct
 */
@WebServlet("/UploadProductController")
public class UploadProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//execution come here from the upload product jsp
	//this is image accept type code
	   private String filePath;
	   private int maxFileSize = 1000 * 4096;
	   private int maxMemSize = 100 * 4096;
	   private File file ;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
      
		  if( !isMultipart ){
             return;
      }
		  
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      // Location to save data that is larger than maxMemSize.
     
      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );

      try{

      // Parse the request to get file items.
      List fileItems = upload.parseRequest(request);

      // Process the uploaded file items
      Iterator i = fileItems.iterator();
  
      //all fields of product
      String productname=null;
      String productprice=null;
      String productweight=null;
      String productdetails=null;
     String filename=null;
      
      while ( i.hasNext())
      {

         FileItem fi = (FileItem)i.next();
         if ( fi.isFormField () )
         {
            // Get the uploaded file parameters
           String  fieldName = fi.getFieldName();
           
         
           if(fieldName.equals("pname"))
             {
        	  productname=fi.getString();
              System.out.println(productname);
             }
           if(fieldName.equals("price"))
           {
        	   productprice=fi.getString();
            System.out.println(productprice);
           }
           if(fieldName.equals("weight"))
             {
        	  productweight=fi.getString();
              System.out.println(productweight);
             }
           if(fieldName.equals("details"))
             {
        	  productdetails=fi.getString();
              System.out.println(productdetails);
             }
         }
         else
          {    
        	 String fieldName = fi.getFieldName();

            if(fieldName.equals("file"))
            {
             ServletConfig sc=getServletConfig();
             String field=fi.getString();
             String contentType = fi.getContentType();
             filename=fi.getName();
              boolean isInMemory = fi.isInMemory();
              long sizeInBytes = fi.getSize();

              //create folder
              File f = new File(sc.getServletContext().getRealPath("/")+"images/") ;
                 if(!f.exists())
                	 f.mkdir();
              // Write the file
              file = new File(sc.getServletContext().getRealPath("/")+"images/"+filename) ;
               fi.write( file ) ;
//              out.println("Uploaded Filename: " +filename + "<br>");
            System.out.println("PATH="+file.getPath());
            }
         }
      }
           
      
       	    int y=0;
    	       ProductDao pd=new ProductDao();//object creation of productdao class
    	       //execution go to  productdao class in uploadproduct method
    	       y=pd.uploadProduct(productname,productprice,productweight,productdetails,filename);//return the integer value
    	     //value come in y while insertion of product
    	       if(y!=0)//condition true then inside block
    		    {	
    	    	   RequestDispatcher rd=request.getRequestDispatcher("uploadProduct.jsp");//forward the page and data with it
    		    	request.setAttribute("msg","Product succuessfully Updated");//msg will send to the page
    		    	rd.forward(request,response);
    		    }
      

      }catch(Exception ex)//exception hanlding
    {
        ex.printStackTrace();//printing exception by printstacktrace method
       System.out.println(ex);//printing exception 
   }

	
	
	
	}

}
