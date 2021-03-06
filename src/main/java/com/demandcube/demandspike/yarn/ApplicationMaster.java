package com.demandcube.demandspike.yarn;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.JCommander;

public class ApplicationMaster extends AbstractApplicationMaster {

    public ApplicationMaster() {
	super();
    }

    @Override
    protected List<String> buildCommandList(int startingFrom, int containerCnt,
	    String commandTemplate) {
	// TODO Auto-generated method stub
	List<String> r = new ArrayList<String>();
	int stopAt = startingFrom + containerCnt;
	for (int i = startingFrom; i < stopAt; i++) {
	    StringBuilder sb = new StringBuilder();
	    sb.append(commandTemplate).append(" ").append(String.valueOf(i));
	    String cmd = sb.toString();
	    LOG.info("curr i : " + i);
	    LOG.info(cmd);
	    r.add(cmd);
	}
	return r;
    }

    public static void main(String[] args) {
	System.out.println("ApplicationMaster::main"); // xxx
	AbstractApplicationMaster am = new ApplicationMaster();
	new JCommander(am, args);
	am.init(args);

	try {
	    am.run();
	} catch (Exception e) {
	    System.out.println("am.run throws: " + e);
	    e.printStackTrace();
	    System.exit(0);
	}
    }

}
