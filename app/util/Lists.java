package util;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	public static <ITEM_TYPE> List<ITEM_TYPE> create(ITEM_TYPE ...items) {
		ArrayList<ITEM_TYPE> list = new ArrayList<ITEM_TYPE>();
		
		for (int i = 0; i < items.length; i++) {
			list.add(items[i]);
		}
		return list;
	}

}
