package chained_list2;


public class ChainedItem<T> {
	
	private T data;
	private ChainedItem<T> next = null;
	
	public ChainedItem(T data){
		this.data = data;
	}
	
	public T getData(){
		return this.data;
	}
	
	public ChainedItem<T> getNext(){
		return this.next;
	}
	
	public void setNext(ChainedItem<T> next){
		this.next=next;
	}

}
