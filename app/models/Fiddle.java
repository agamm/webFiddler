package models;
import play.*;
//import java.util.*;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import play.db.jpa.*;

@Entity
public class Fiddle extends GenericModel {
	public String html;
	public String css;
	public String js;
	
  	@Id 
    public String uuid;
	
	// Constractor
	public Fiddle(String html, String css, String js){
		this.uuid = java.util.UUID.randomUUID()+"";
		this.html = html;
		this.css = css;
		this.js = js;
	}
	
	// Remove fiddle
	public static void delete(String uuid){
		Fiddle wFiddle = Fiddle.findById(uuid);
		wFiddle.delete();
	}
	
	public static Fiddle getFiddle(String uuid){
		Logger.info("\nGet ID [ %s ]",uuid);
		return (Fiddle)Fiddle.find("uuid", uuid).fetch().get(0);
	}
	/*// Return the HTML of the fiddle
	public String getHtml(){
		String data = this.htmlData;
		if(data != null && data.length()>0){
			return data;
		}
		return "null";
	}
	
	// Return the CSS of the fiddle
	public String getCss(){
		String data = this.cssData;
		if(data != null && data.length()>0){
			return data;
		}
		return "null";
	}
	
	// Return the Javascript of the fiddle
	public String getJs(){
		String data = this.jsData;
		if(data != null && data.length()>0){
			return data;
		}
		return "null";
	}*/
	
	
}
