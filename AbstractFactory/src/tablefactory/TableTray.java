package tablefactory;

import java.util.Iterator;

import factory.Item;
import factory.Tray;

// 具体的な部品
// Trayクラスのサブクラス
public class TableTray extends Tray {

	public TableTray(String caption) {
		super(caption);
	}

	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<td>");
		buffer.append("<table wieth=¥100%¥ border=¥1¥><tr>");
		buffer.append("td bgcolor=¥ align=¥center¥" + tray.size() + "¥ ><b>" + caption + "</b></td>");
		buffer.append("</tr>¥n");
		buffer.append("<tr>¥n");
		Iterator it = tray.iterator();
		while (it.hasNext()) {
			Item item = (Item)it.next();
			buffer.append(item.makeHTML());
		}
		buffer.append("</tr></table>");
		buffer.append("</td>");
		return buffer.toString();

	}

}
