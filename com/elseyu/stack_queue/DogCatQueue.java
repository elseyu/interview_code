package com.elseyu.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现猫狗队列：
 * 有如下几个类：Pet、Cat、Dog，实现一种猫狗队列的结构，要求如下：
 * 1.add()方法可以将cat或dog实例放入队列之中
 * 2.poll()方法可以按先后次序弹出最早进入的宠物
 * 3.pollDog()方法可以按先后次序弹出最早进入的狗
 * 4.pollCat()方法可以按先后次序弹出最早进入的猫
 * 5.isEmpty()判断队列是否为空
 * 6.isDogEmpty()判断队列狗是否为空
 * 7.isCatEmpty()判断队列猫是否为空
 *
 */
class Pet {
	private String type;
	
	public Pet(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
}

class Dog extends Pet {

	public Dog() {
		super("dog");
	}
}

class Cat extends Pet {
	
	public Cat() {
		super("cat");
	}
}


/**
 *	实现方法如下：
 *	1.设计一个新的类，PetNode类，里面包含有Pet实例，同时这个类还有一个count的时间戳，
 *	它保存了每个实例入队时“时间”（其实就是一个计数器） 
 *	2.DogCatQueue类包含两个Queue，实现所有需要实现的方法，只需要注意入队的时候要传入正确的时间戳数值，
 *	出队时要先比较DogQueue和CatQueue队头的时间戳（谁小谁先出队）
 */
class PetNode {
	private Pet pet;
	private int count;
	
	public PetNode(Pet pet,int count) {
		
		this.count = count;
		this.pet = pet;
	}
	
	public Pet getPet() {
		return this.pet;
	}
	
	public String getPetType() {
		return this.pet.getType();
	}
	
	public int getCount() {
		return this.count;
	}
}

/**
 *	实现类
 */
public class DogCatQueue {
	private Queue<PetNode> dogQueue;
	private Queue<PetNode> catQueue;
	private int count; //生成时间戳
	
	public DogCatQueue() {
		dogQueue = new LinkedList<>();
		catQueue = new LinkedList<>();
		this.count = 0;
	}
	
	public void add(Pet pet) {
		if(pet.getType().equals("dog")) {
			this.dogQueue.add(new PetNode(pet, this.count++));
		} else if (pet.getType().equals("cat")) {
			this.catQueue.add(new PetNode(pet, this.count++));
		} else {
			throw new RuntimeException("err,not a cat or dog");
		}
	}
	
	
	public Pet pollAll() {
		//都不为空时比较队头的时间戳，谁小谁先出
		if(!dogQueue.isEmpty() && !catQueue.isEmpty()) {
			if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
				return dogQueue.poll().getPet();
			} else {
				return catQueue.poll().getPet();
			}
			
			//只有一个不为空时，直接出队
		} else if (!dogQueue.isEmpty()) {
			return dogQueue.poll().getPet();
		} else if (!catQueue.isEmpty()) {
			return catQueue.poll().getPet();
		} else {
			throw new RuntimeException("Queue is empty!");
		}
	}
	
	public Dog pollDog() {
		if (!dogQueue.isEmpty()) {
			return (Dog) dogQueue.poll().getPet();
		} else {
			throw new RuntimeException("Dog queue is empty!");
		}
	}
	
	public Cat pollCat() {
		if (!dogQueue.isEmpty()) {
			return (Cat) dogQueue.poll().getPet();
		} else {
			throw new RuntimeException("Cat queue is empty!");
		}
	}
	
	public boolean isEmpty() {
		return dogQueue.isEmpty() && catQueue.isEmpty();
	}
	
	public boolean isDogEmpty() {
		return dogQueue.isEmpty();
	}
	
	public boolean isCatEmpty() {
		return catQueue.isEmpty();
	}
	
}




