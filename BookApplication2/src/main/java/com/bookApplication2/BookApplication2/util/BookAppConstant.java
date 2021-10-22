package com.bookApplication2.BookApplication2.util;

import javax.persistence.Column;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BookAppConstant {
	
	
	
	
	
	// START Book Model Constant 
	public static final String TABLE_BOOKTABLENAME = "book";

	public static final String COL_BOOKNAME = "book_name";
	public static final String COL_BOOKPRICE = "book_price";
	public static final String COL_BOOKDETAILS = "book_details";
	public static final String COL_BOOKSTOCK = "book_stock";
	public static final String COL_BOOKCREATEDATE = "book_create_date";
	//public static final String COL_BOOKIMAGENAME = "book_image_name";
	public static final String COL_BOOKAUTHORID = "author_id";
	public static final String COL_CATEGORYID = "category_id";
	public static final String COL_BOOKIMAGENAME = "name";
	public static final String COL_BOOKIMAGETYPE = "type";
	public static final String COL_BOOKIMAGEPICBYTE = "picByte";

	// END Book Model Constant 
	
	// START Author Model Constant 
	
	public static final String TABLE_AUTHORTABLENAME = "author";

	
	public static final String COL_AUTHORNAME = "author_name";

	public static final String COL_AUTHORABOUT = "author_about";
	//public static final String COL_IMAGENAME = "book_name";
	public static final String COL_AUTHORIMAGENAME = "name";
	public static final String COL_AUTHORIMAGETYPE = "type";
	public static final String COL_AUTHORIMAGEPICBYTE = "picByte";
	public static final String COL_LISTAUTHORID = "author_id";
	public static final String COL_AUTHORCREATEDATE = "create_date";
	public static final String COL_AUTHORUPDATEDATE = "update_date";

	// END Author Model Constant 
	
	// START BookOrder Model Constant 
	public static final String TABLE_BOOKORDERTABLENAME = "book_orders";

	
	public static final String COL_ORDERBOOKNAME = "book_name";
	public static final String COL_ORDERBOOKPRICE = "book_price";
	public static final String COL_ORDERBOOKPIECE = "book_piece";
	public static final String COL_ORDERTOTALPIECE = "total_price";
	public static final String COL_ORDERORDERNUMBER = "order_number";
	public static final String COL_ORDERADDRESS = "address";
	public static final String COL_ORDERUSERNAME = "username";
	public static final String COL_ORDERCRATETIME = "createTime";

	// END BookOrder Model Constant 

	
	// START CATEGORY Model Constant 
	public static final String TABLE_CATEGORYTABLENAME = "category";


	public static final String COL_CATEGORYCATEGORYNAME = "category_name";
	public static final String COL_CATEGORYIMAGENAME = "name";
	public static final String COL_CATEGORYIMAGETYPE = "type";
	public static final String COL_CATEGORYIMAGEPICBYTE = "picByte";

	
	// END CATEGORY Model Constant 

	
	
	// START COMMENT Model Constant 
	public static final String TABLE_COMMENTTABLENAME = "comments";

	
	public static final String COL_COMMENTCOMMENTNAME = "comment";
	public static final String COL_COMMENTCREATETIME = "create_time";
	public static final String COL_COMMENTBOOKID = "book_id";
	public static final String COL_COMMENTUSERID = "user_id";

	
	// END COMMENT Model Constant 

	
	// START SLİDER Model Constant 
	public static final String TABLE_SLIDERTABLENAME = "slider";

	
	public static final String COL_SLİDERSLIDERSTATE = "sliderState";
	public static final String COL_SLIDERSLIDERIMAGENAME = "name";
	public static final String COL_SLIDERSLIDERIMAGETYPE = "type";
	public static final String COL_SLIDERSLIDERIMAGEPICBYTE = "picByte";

	
	// END SLİDER Model Constant 
	
	
	
	// Start User Model Constant 
	public static final String TABLE_USERTABLENAME = "users";

	public static final String COL_USERUSERNAME = "username";
	public static final String COL_USERUSEREMAIL = "email";
	public static final String COL_USERUSERPASSWORD = "password";
	public static final String COL_USERPERSONNAME = "name";
	public static final String COL_USERPERSONSURNAME = "surname";
	public static final String COL_USERPERSONPHONENUMBER = "userPhoneNumber";
	public static final String COL_USERADDRESS = "userAddress";
	public static final String COL_USERCREATETIME = "createTime";

	public static final String COL_USERUSERROLES = "user_roles";

	public static final String COL_USERIMAGENAME = "imageName";
	public static final String COL_USERIMAGETYPE = "type";
	public static final String COL_USERIMAGEPICBYTE = "picByte";

	
	
	// END User Model Constant 
	
	
	
	
	

}
