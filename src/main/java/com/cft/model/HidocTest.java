/*package com.cft.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;

public class HidocTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws MalformedURLException, IOException {

		JSONArray sortedJsonArray = new JSONArray();
		JSONArray jsonArray = new JSONArray();
		URL url = new URL("http://api.springernature.com/meta/v2/json?q=keyword:cancer&api_key=74ef104617117e6baf69ae1e76992b0b");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String str = "";
		while (null != (str = br.readLine())) {
			JSONObject json = new JSONObject(str);
			org.json.JSONArray jsonRcrd= json.getJSONArray("records");
			Iterator itr = jsonRcrd.iterator();
			int count =0;  
			JSONObject jsObj = new JSONObject();

			while (itr.hasNext()) {
				JSONObject jsnObj = new JSONObject();
				Object slide = itr.next();
				JSONObject js = (JSONObject) slide;
				String pName = (String) js.get("publicationName");
				String abstrct = (String) js.get("abstract");
				String pdate = (String) js.get("publicationDate");
				String odate = (String) js.get("onlineDate");
				String publisher = (String) js.get("publisher");

				JSONObject jsncrtr=jsonRcrd.getJSONObject(count);
				org.json.JSONArray  jarrCreator = jsncrtr.getJSONArray("creators");

				//changing the name of keys 
				jsnObj.put("publicationName", pName);
				jsnObj.put("publisherStr", publisher);
				jsnObj.put("abstractStr", abstrct);
				jsnObj.put("publicationDateStr", pdate);
				jsnObj.put("onlineDateStr", odate);
				jsonArray.add(jsnObj);

				JSONArray jsonArr= new JSONArray();
				JSONObject jsonObj=null;
				for (int i = 0; i < jarrCreator.length(); i++) {
					jsonObj = jarrCreator.getJSONObject(i);
					jsonArr.add(jsonObj);
					jsnObj.put("creators", jsonArr);
				}
				count++;
			}
			jsObj.put("records", jsonArray);
			List<JSONObject> jsonValues = new ArrayList<JSONObject>();
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonValues.add( (JSONObject) jsonArray.get(i));
			}

			Collections.sort( jsonValues, new Comparator<JSONObject>() {
				private static final String KEY_NAME = "onlineDateStr";
				public int compare(JSONObject a, JSONObject b) {
					String valA = new String();
					String valB = new String();
					try {
						valA = (String) a.get(KEY_NAME);
						valB = (String) b.get(KEY_NAME);
					} 
					catch (JSONException e) {
						e.printStackTrace();
					}
					return valA.compareTo(valB);
				}
			});
			
			
			
			System.out.println("jsonValues  "+jsonValues);
			for (int i =  jsonArray.size()-1; i >=0; i--) {
				sortedJsonArray.add(jsonValues.get(i));
			} 
			System.out.println(sortedJsonArray);

		}
	}
}*/