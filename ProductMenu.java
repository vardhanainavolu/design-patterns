import java.text.ParseException;

public interface ProductMenu {

	public abstract void showMenu();

	public abstract Offering showAddButton() throws ParseException;

	public abstract void showViewButton();

	public abstract void showRadioButton();

	public abstract void showLabels();

	public abstract void showComboxes();

	public abstract void setProductList(ClassProductList productList);

}
