package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class UpdateImageController
 */
@WebServlet("/UpdateImageController")
public class UpdateImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	   private String filePath;
	   private int maxFileSize = 1000 * 4096;
	   private int maxMemSize = 100 * 4096;
	   private File file ;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateImageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
    String pid=null;
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
         if(fieldName.equals("pid"))
         {
    	  pid=fi.getString();
          System.out.println(pid);
         }
      
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
            out.println("Uploaded Filename: " +filename + "<br>");
          System.out.println("PATH="+file.getPath());
          }
       }
    }
         //get the field by name from jsp page
                    pid=pid.trim();
                    int pid1=Integer.parseInt(pid);
     	    int y=0;
  	       ProductDao pd=new ProductDao();//object creation of product dao class
  	       //by this object calling the method for update the image
  	       y=pd.updateImage(pid1,filename);//return the integer value
  	       System.out.println("y in update image "+y);
  	     if(y!=0)//if image update condition true
  		    {	
  	    	 //forward the execution to the view product controller with the data
  	    	    RequestDispatcher rd=request.getRequestDispatcher("ViewProductController");
  		    	request.setAttribute("msg","Product Image succuessfully Updated");
  		    	rd.forward(request,response);
  		    }
    

    }catch(Exception ex)//exception handling
  {
      ex.printStackTrace();//print the exception detail
    
 }
	
	}

}
