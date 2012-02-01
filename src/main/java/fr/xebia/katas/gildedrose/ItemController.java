package fr.xebia.katas.gildedrose;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

	@RequestMapping("/")
	@ResponseBody
	public String displayList() {

		Inn inn = new Inn();

		List<LifecycleItem> items = inn.getItems();

		String html = "<html><head><title>Items !</title></head><body>%s</body></html>";

		return String.format(html, items.toString());
	}
}
