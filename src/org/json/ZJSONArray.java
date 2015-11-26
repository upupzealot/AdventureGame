package org.json;

public class ZJSONArray extends JSONArray {
	public int indexOf(Object value) {
		for (int i = 0; i < this.length(); i++) {
			if(get(i).equals(value)) {
				return i;
			}
		}
		return -1;
	}
}
