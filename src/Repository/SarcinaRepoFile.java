package Repository;

import Entities.Sarcina;
import Validator.ValidatorException;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Andrei on 10/31/2016.
 */
public class SarcinaRepoFile extends SarcinaRepo{
    public String fname;
    public SarcinaRepoFile(String fname) throws ValidatorException{
        super();
        this.fname=fname;
        try {
            this.loadFromFile();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
    }

    private void loadFromFile() throws FileNotFoundException, ValidatorException{
        String line ;
        String argv[] = new String [2];
        try(
                BufferedReader reader =  new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
        ) {
            while ((line = reader.readLine())!=null) {
                StringTokenizer tk = new StringTokenizer(line,"|");
                Sarcina b = new Sarcina(Integer.parseInt(tk.nextToken()),tk.nextToken());
                this.save(b);
            }
        }
        catch (IOException exc){
            //exc.printStackTrace();
        }

    }
    public void saveToFile(){
        try(
                BufferedWriter writer =  new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.fname)));
        ) {
            for(Sarcina sarcina: this.lista)
            {
                String line = sarcina.getId() + "|" + sarcina.getDescriereSarcina() + "\n";
                writer.write(line);
            }
        }
        catch (IOException exc){
            //exc.printStackTrace();
        }

    }
}
