package chained_list2;


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ChainedList<T>  implements Iterable<T>, Comparator<T>{
	
	private ChainedItem<T> head = null;
	ChainedItem<T> pointer=null;
	
	public ChainedItem<T> getHead(){
		return this.head;
	}
	
	public int getSize(){
		
		if(this.head==null){
			return 0;
		}
		int size = 1;
		ChainedItem<T> item=this.head.getNext(); 	
		while(item!=null){
			item = item.getNext();
			size++;
		}
		return size;	
	}
	
	public boolean isEmpty(){
		return this.head==null;
	}
	public void add(T data){
		if(this.isEmpty()){
			this.head = new ChainedItem<T>(data);
			return;
		}
		ChainedItem<T> item=this.head; 	
		while(item.getNext()!=null){
			item = item.getNext();
		}
		item.setNext(new ChainedItem<T>(data));
		
	}

	public void add(T data, int rank){
		if(rank>this.getSize()){
			throw new IndexOutOfBoundsException();
		}
		if(this.isEmpty()){
			this.head = new ChainedItem<T>(data);
			return;
		}
		if(rank==0){
			ChainedItem<T> next = this.head;
			this.head = new ChainedItem<T>(data);
			this.head.setNext(next);
			return;
		}

		if(rank ==this.getSize()){
			this.getItem(rank-1).setNext(new ChainedItem<T>(data));
			return;
		}
		
		ChainedItem<T> item = this.getItem(rank);
		ChainedItem<T> added = new ChainedItem<T>(data);
		this.getItem(rank-1).setNext(added);
		added.setNext(item);
	}
	
	
	public void remove(int rank) {
		if(this.head==null || this.getSize()<rank){
			System.out.println("erreur");
			return;
		}
		if(rank==0){
			this.head=this.head.getNext();
			return;
		}
		this.getItem(rank-1).setNext(this.getItem(rank+1));
		
	}
	
	public void remove(T data) {
		if(this.head==null){
			throw new IndexOutOfBoundsException();
		}
		if(this.head.getData()==data){
			this.head=this.head.getNext();
			return;
		}
		ChainedItem<T> item = this.head.getNext();
		ChainedItem<T> prev = this.head;
		while(item.getData()!=data){
			if(item.getNext()==null){
				throw new IndexOutOfBoundsException();
			}
			prev = item;
			item = item.getNext();
		}
		prev.setNext(item.getNext());
	}
	
	public void empty(){
		if(this.head==null){
			throw new IndexOutOfBoundsException();
		}
		while(this.head!=null){
			System.out.print(this.head.getData());	
			this.remove(0);
		}
	}
	
	public ChainedItem<T> getItem(int rank){
		if(this.head==null){
			throw new IndexOutOfBoundsException();
		}
		if(rank>=this.getSize()){
			throw new IndexOutOfBoundsException();
		}
		if(rank == 0) return this.head;
		ChainedItem<T> item = this.getHead();
		for(int i = 0;i<rank;i++){
			item = item.getNext();
		}
		return item;
		
	}
	
	public void sortAscending(){
		if (this.head == null){
			throw new IndexOutOfBoundsException();
		}
		for(int i=0;i<this.getSize();i++){
			
			ChainedItem<T> min = this.getItem(i);
			ChainedItem<T> ptr = this.getItem(i);	
		while(ptr!=null){
			if(compare(min.getData(),ptr.getData())==1){
				min = ptr;
			}
			ptr = ptr.getNext();
		}
		this.remove(min.getData());
		this.add(min.getData(),i);
		}
	}
	

	@Override
	public Iterator<T> iterator() {	
		final ChainedItem<T> firstItem = this.head;
		
		final boolean empty = this.isEmpty();
		return new Iterator<T> (){
			
			
			@Override
			public boolean hasNext() {
				return(!empty && pointer!=null && pointer.getNext()!=null);	
			}

			@Override
			public T next() {	
				if(pointer==null){
					pointer=firstItem;
				}
					
				if (empty || pointer.getNext()==null)  {
					throw new NoSuchElementException();
				}
				
				return pointer.getNext().getData();		
			}
			
		};
	}

	@Override
	public int compare(T arg0, T arg1) {
		// TODO Auto-generated method stub
		if(arg0.toString().compareTo(arg1.toString())>0){
			return 1;
		}else if(arg0.toString().compareTo(arg1.toString())<0){
			return -1;
		}else{
			return 0;
		}	
	}


}
