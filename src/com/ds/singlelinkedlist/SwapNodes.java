package com.ds.singlelinkedlist;

public class SwapNodes {

	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList() ;
		linkedList.head = linkedList.new Node() ;
		linkedList.head.data = 10 ;
		
		linkedList.head.nextNode = linkedList.new Node() ;
		linkedList.head.nextNode.data = 15 ;
		
		linkedList.head.nextNode.nextNode = linkedList.new Node() ;
		linkedList.head.nextNode.nextNode.data = 12 ;
		
		linkedList.head.nextNode.nextNode.nextNode = linkedList.new Node() ;
		linkedList.head.nextNode.nextNode.nextNode.data = 13 ;
		
		linkedList.head.nextNode.nextNode.nextNode.nextNode = linkedList.new Node() ;
		linkedList.head.nextNode.nextNode.nextNode.nextNode.data = 20 ;
		
		linkedList.head.nextNode.nextNode.nextNode.nextNode.nextNode = linkedList.new Node() ;
		linkedList.head.nextNode.nextNode.nextNode.nextNode.nextNode.data = 14 ;
		
		new SwapNodes().getSwappedList(linkedList, 12, 13);
	}
	
	private void getSwappedList(SingleLinkedList list, int x, int y) {
		if(list == null || list.head == null) {
			System.out.println("list not initialised");
//			return list ;
		}
		
		SingleLinkedList.Node preEarlierNode = null ;
		SingleLinkedList.Node earlierNode = null;
		SingleLinkedList.Node postEarlierNode = null;
		
		SingleLinkedList.Node preAfterNode= null ;
		SingleLinkedList.Node afterNode = null;
		SingleLinkedList.Node postAfterNode = null;
		
		SingleLinkedList.Node currentNode = list.head ;
		SingleLinkedList.Node tempPrevNode = null ;
		
		while (currentNode != null) {
			if(currentNode.data == x || currentNode.data == y) {
				if(earlierNode == null) {
					preEarlierNode = tempPrevNode ;
					earlierNode = currentNode ;
				}else {
					preAfterNode = tempPrevNode ;
					afterNode = currentNode ;
				}
			}
			tempPrevNode = currentNode ;
			currentNode = currentNode.nextNode ;
		}
		
		if(earlierNode == null || afterNode == null) {
			System.out.println("elements not found");
//			return list ;
		}
		
		postAfterNode = afterNode.nextNode ;
		postEarlierNode = earlierNode.nextNode ;
		
		if(preEarlierNode != null) {
			preEarlierNode.nextNode = afterNode ;
		}else {
			list.head = afterNode ;
		}
		
		if(postEarlierNode.data != afterNode.data) {
			afterNode.nextNode = postEarlierNode ;
			preAfterNode.nextNode = earlierNode ;
		}else {
			afterNode.nextNode = earlierNode ;
		}
		
		earlierNode.nextNode = postAfterNode ;
		
		currentNode = list.head ;
		while(currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.nextNode;
		}
	}

}
