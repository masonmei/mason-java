package org.personal.mason.designpattern.structural.adapter;
public class Adapter {
public static void main(String[] args) {
	HKSocket hksocket = new HKSocket();
	HK2CNSocketAdapter adapter = new HK2CNSocketAdapter(hksocket);
	System.out.println(adapter.getLiveWireSize());
}
}

class HKSocket {
public int getLiveWireSize() {
	return 10;
}
}

class CNSocket {
public int getLiveWireSize() {
	return 5;
}
}

class HK2CNSocketAdapter extends CNSocket {
private HKSocket hkSocket;
public HK2CNSocketAdapter(HKSocket hkSocket) {
	this.hkSocket = hkSocket;
}
@Override
public int getLiveWireSize() {
	return this.hkSocket.getLiveWireSize() / 2; 
}
}