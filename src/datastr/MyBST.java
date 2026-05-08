package datastr;

public class MyBST<Ttype> {
	private MyNode<Ttype> root = null;
	private int howManyElements = 0;

	public int getHowManyElements() {
		return howManyElements;
	}

	public boolean isEmpty() {
		return (howManyElements == 0);
	}

	public boolean isFull() {
		try {
			new MyNode('a');
			return false;
		} catch (OutOfMemoryError error) {
			return true;
		}

	}


	public void add(Ttype element) throws Exception {
		if (element == null) {
			throw new Exception("Nepareizi ievades dati");
		}

		if (isFull()) {
			throw new Exception("BST ir pilns un nevar ievietot elementu");
		}

		if (isEmpty()) {
			MyNode newNode = new MyNode(element);
			root = newNode;
			howManyElements++;
		} else {
			addHelper(element, root);
			howManyElements++;
		}
	}

	private void addHelper(Ttype element, MyNode nodeTemp) {

		Ttype elementCompare = (Ttype) nodeTemp.getElement();
		// veicam salīdzināšanu vai iet uz labo pusi vai uz kreiso
		// ja jaunais elements ir lielāks
		if (((Comparable) element).compareTo(elementCompare) > 0) {
			if(nodeTemp.getRightChildNode() == null) {
				MyNode newNode = new MyNode(element);
				nodeTemp.setRightChildNode(newNode);
				newNode.setParentNode(nodeTemp);
			}
			else
			{
				addHelper(element, nodeTemp.getRightChildNode());
			}

		}//javirzas uz kreiso pusi
		else
		{
			if(nodeTemp.getLeftChildNode() == null) {
				MyNode newNode = new MyNode(element);
				nodeTemp.setLeftChildNode(newNode);
				newNode.setParentNode(nodeTemp);
			}
			else
			{
				addHelper(element, nodeTemp.getLeftChildNode());
			}
		}
	}

	public void print() throws Exception {
		if (isEmpty()) {
			throw new Exception("Kaudze ir tukša un nav elementu, ko printēt");
		}

		printHelper(root);

	}

	private void printHelper(MyNode node) {
		if (node != null) {
			System.out.println("P: " + node.getElement());

			if (node.getLeftChildNode() != null) {
				System.out.println("P: " + node.getElement() + " LC: " + node.getLeftChildNode().getElement());
				printHelper(node.getLeftChildNode());
			}

			if (node.getRightChildNode() != null) {
				System.out.println("P: " + node.getElement() + "RC: " + node.getRightChildNode().getElement());
				printHelper(node.getRightChildNode());
			}
		}
	}
}
