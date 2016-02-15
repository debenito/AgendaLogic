package benito.agenda.servidor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public abstract class HttpServicio {
	URL url ;
	URLConnection con;
	public HttpServicio(String url){
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	 public void AbrirConexion(){
		 try {
			this.con = this.url.openConnection();
			execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public abstract void execute();
}
