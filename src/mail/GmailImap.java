//package mail;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Properties;
//
//import javax.mail.BodyPart;
//import javax.mail.Folder;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.Session;
//import javax.mail.Store;
//import javax.mail.internet.ContentType;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMultipart;
//
//public class GmailImap {
//	
////	public GmailImap() {
////
////	main(null);
////	}
//	 
//	 private static final String email_id = "ufeedbackus@gmail.com";
//	 private static final String password = "m23912391";
//	 
//	 
//	 public static void main(String[] args) {
//		abc();
//		
//	}
//	 public static void abc(){  //main(String[] args) {
//	 
//	 
//	  //set properties 
//	  Properties properties = new Properties();
//	  //You can use imap or imaps , *s -Secured
//	  properties.put("mail.store.protocol", "imaps");
//	  //Host Address of Your Mail
//	  properties.put("mail.imaps.host", "imap.gmail.com");
//	  //Port number of your Mail Host
//	  properties.put("mail.imaps.port", "993");
//	 
//	  //properties.put("mail.imaps.timeout", "10000");
//	 
//	  try {
//	 
//	   //create a session  
//	   Session session = Session.getDefaultInstance(properties, null);
//	   //SET the store for IMAPS
//	   Store store = session.getStore("imaps");
//	 
//	   System.out.println("Connection initiated......");
//	   //Trying to connect IMAP server
//	   store.connect(email_id, password);
//	   System.out.println("Connection is ready :)");
//	 
//	 
//	   //Get inbox folder 
//	   Folder inbox = store.getFolder("inbox");
//	   //SET readonly format (*You can set read and write)
//	   inbox.open(Folder.READ_ONLY);
//	 
//	 
//	   //Display email Details 
//	 
//	   //Inbox email count
//   int messageCount = inbox.getMessageCount();
//	 //  Message[] messageCount2 = inbox.getMessages();
//	//   String ss = messageCount2.toString();
//	 //  for(String s : messageCount2){
//	//	   System.out.println(s);
//	 //  }
//	   System.out.println("Total Messages in INBOX:- " + messageCount);
//	 
//	   //Print Last 10 email information
//	   for (int i = 1; i > 0; i--) {
//	    System.out.println("Mail Subject:- " + inbox.getMessage(messageCount - i).getSubject());
//	    System.out.println("Mail From:- " + inbox.getMessage(messageCount - i).getFrom()[0]);
//	    System.out.println("Mail Content:- " + inbox.getMessage(messageCount - i).getContent().toString());
//	    System.out.println("------------------------------------------------------------");
//	   
////	    List<String> lines =inbox.getMessage(messageCount - i).getFrom()[0]);// Arrays.asList("The first line", "The second line");
////	    Path file = Paths.get("C:\\eclipseworkplace\\Coveros_Test2\\src\\main\\java\\StepDefinitions\\test.txt");
////	    Files.write(file, lines, Charset.forName("UTF-8"));
//	   
//	   
//	   try {
//           FileWriter writer = new FileWriter("C:\\eclipseworkplace\\Coveros_Test2\\src\\main\\java\\StepDefinitions\\test.txt", true);
//           writer.write(inbox.getMessage(messageCount - i).getContent().toString());//.substring(11, 17));
//          writer.write("\r\n");   // write new line
//     //      writer.write("Good Bye!");
//           writer.close();
//       } catch (IOException e) {
//           e.printStackTrace();
//       }}
//	   inbox.close(true);
//	   store.close();
//	 
//	  } catch (Exception e) {
//	   e.printStackTrace();
//	  }}}
//	  
//	   
////	   
////	 private String getTextFromMessage(Message message) throws IOException, MessagingException {
////		    String result = "";
////		    if (message.isMimeType("text/plain")) {
////		        result = message.getContent().toString();
////		    } else if (message.isMimeType("multipart/*")) {
////		        MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
////		        result = getTextFromMimeMultipart(mimeMultipart);
////		    }
////		    return result;
////		}
////
////		private String getTextFromMimeMultipart(
////		        MimeMultipart mimeMultipart) throws IOException, MessagingException {
////
////		    int count = mimeMultipart.getCount();
////		    if (count == 0)
////		        throw new MessagingException("Multipart with no body parts not supported.");
////		    boolean multipartAlt = new ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
////		    if (multipartAlt)
////		        // alternatives appear in an order of increasing 
////		        // faithfulness to the original content. Customize as req'd.
////		        return getTextFromBodyPart(mimeMultipart.getBodyPart(count - 1));
////		    String result = "";
////		    for (int i = 0; i < count; i++) {
////		        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
////		        result += getTextFromBodyPart(bodyPart);
////		    }
////		    return result;
////		}
////
////		private String getTextFromBodyPart(
////		        BodyPart bodyPart) throws IOException, MessagingException {
////
////		    String result = "";
////		    if (bodyPart.isMimeType("text/plain")) {
////		        result = (String) bodyPart.getContent();
////		    } else if (bodyPart.isMimeType("text/html")) {
////		        String html = (String) bodyPart.getContent();
////		        result = org.jsoup.Jsoup.parse(html).text();
////		    } else if (bodyPart.getContent() instanceof MimeMultipart){
////		        result = getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
////		    }
////		    return result;
////		}	}    
//		    
////       Message msg = inbox.getMessage(inbox.getMessageCount());
////
////	   Multipart mp = (Multipart) msg.getContent();
////       BodyPart bp = mp.getBodyPart(0);
////       System.out.println("SENT DATE:" + msg.getSentDate());
////       System.out.println("SUBJECT:" + msg.getSubject());
////       System.out.println("CONTENT:" + bp.getContent());
////	   
////	   String contentType = msg.getContentType();
////	    String messageContent="";
////
////	   if (contentType.contains("multipart")) {
////	        Multipart multiPart = (Multipart) msg.getContent();
////	        int numberOfParts = multiPart.getCount();
////	        for (int partCount = 0; partCount < numberOfParts; partCount++) {
////	            MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
////	                messageContent = part.getContent().toString();
////	        }
////	    }
////	    else if (contentType.contains("text/plain")
////	            || contentType.contains("text/html")) {
////	        Object content = msg.getContent();
////	        if (content != null) {
////	            messageContent = content.toString();
////	        }
////	    }
////	     System.out.println(" Message: " + messageContent);
//
//
//	   
////	   FileOutputStream out = new FileOutputStream("C:\\eclipseworkplace\\Coveros_Test2\\src\\main\\java\\StepDefinitions\\test.txt");
////	   out.write(ss);
////	   out.close();
//	 
//	
//	
//	
