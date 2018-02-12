package zad3;

public interface Iterator {
	public void first();
	public void last();
	public void previous();
	public void next();
	public boolean isDone();
	public Object current();
}
