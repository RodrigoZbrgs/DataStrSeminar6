package datastr;

public class MyNode<Ttype> {
	private Ttype element;
	private MyNode rightChildNode = null;
	private MyNode leftChildNode = null;
	private MyNode parentNode = null;
	
	//getters
	public MyNode getRightChildNode() {
		return rightChildNode;
	}
	public MyNode getLeftChildNode() {
		return leftChildNode;
	}
	public MyNode getParentNode() {
		return parentNode;
		}
	
	public Ttype getElement() {
		return element;
		
	}
	public void setElement(Ttype element) {
		if(element != null) {
			this.element = element;
		}
		else {
		this.element = (Ttype)new Object();
		}
	}
	//setters
	public void setRightChildNode(MyNode rightChildNode) {
		this.rightChildNode = rightChildNode;
	}

	public void setLeftChildNode(MyNode leftChildNode) {
		this.leftChildNode = leftChildNode;
	}

	public void setParentNode(MyNode parentNode) {
		this.parentNode = parentNode;
	}

	//4.konstruktors
	public MyNode(Ttype element) {
		setElement(element);
	}
	
	//5.
	public String toString() {
		return "" + element;
	}
}
