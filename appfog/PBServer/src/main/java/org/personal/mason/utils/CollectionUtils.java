package org.personal.mason.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;

public class CollectionUtils {

public static <T> List<T> pageToList(Page<T> pageElement) {
	Iterator<T> iterator = pageElement.iterator();
	List<T> list = new ArrayList<T>();
	while (iterator.hasNext()) {
		list.add(iterator.next());
	}
	return list;
}

}
