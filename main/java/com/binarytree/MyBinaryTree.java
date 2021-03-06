package com.binarytree;

public class MyBinaryTree<K extends Comparable<K>>
{
	private MyBinaryNode<K> root;
	public void add(K key)
	{
		this.root=this.addRecursively(root,key);
	}
	private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current,K key)
	{
		if(current==null)
			return new MyBinaryNode<K>(key);
		int compareResult=key.compareTo(current.key);
		if(compareResult==0)
			return current;
		if(compareResult<0)
			current.left=addRecursively(current.left, key);
		else
			current.right=addRecursively(current.right, key);
		return current;
	}
	public boolean containsNode(K key)
	{
	    return containsNodeRecursive(root, key);
	}
	private boolean containsNodeRecursive(MyBinaryNode<K> current,K key) 
	{
	    if (current == null) 
	    {
	        return false;
	    } 
	    int compareResult=key.compareTo(current.key);
	    if(compareResult==0)
	    {
	    	return true;
	    }
	    return(compareResult<0)?containsNodeRecursive(current.left, key):
	    	containsNodeRecursive(current.right, key);
	}
	public int getSize()
	{
		return this.getSizeRecursive(root);
	}
	private int getSizeRecursive(MyBinaryNode<K> current)
	{
		return current==null?0:1+this.getSizeRecursive(current.right)+this.getSizeRecursive(current.left);
	}
}
