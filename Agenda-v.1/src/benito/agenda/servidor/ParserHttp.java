package benito.agenda.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ParserHttp extends HttpServicio{

	public ParserHttp(String url) {
		super(url);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute()  {
		// TODO Auto-generated method stub
		 InputStream is;
		try {
			is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			leerFicheroRetorno(br);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	}

	private void leerFicheroRetorno(BufferedReader br) throws IOException {
		while(br.readLine()!= null){
			 br.readLine();
		}
			
	}

}
