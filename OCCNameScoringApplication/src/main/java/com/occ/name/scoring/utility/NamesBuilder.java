package com.occ.name.scoring.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.occ.name.scoring.entity.Name;
import com.occ.name.scoring.io.FileLoader;
import com.occ.name.scoring.io.InvalidFileException;


public class NamesBuilder {
	
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(NamesBuilder.class.getName());

	public List<Name> loadAndBuildNames(String file)throws InvalidFileException,IOException,Exception { 
		FileLoader fileLoader = new FileLoader();
		try {
			return readIOStream(fileLoader.loadFile(new File(file)));
		}catch(IOException | InvalidFileException ex) {
			//ex.printStackTrace();
			throw ex;
		}
		catch(Exception ex) {
			//ex.printStackTrace();
			throw ex;
		}
	}
	
	public List<Name> loadAndBuildNames(byte[] buffer) throws IOException,Exception { 
		
		FileLoader fileLoader = new FileLoader();
		
		try {
			return readIOStream(fileLoader.getBufferedReader(buffer));
		}catch(IOException | InvalidFileException ex) {
			//ex.printStackTrace();
			throw ex;
		}
		catch(Exception ex) {
			//ex.printStackTrace();
			throw ex;
		}
	}
	private List<Name> readIOStream(BufferedReader br) throws IOException,Exception{
		String line=null;
		List<String> names=null;
		try {
		while ((line = br.readLine()) != null) {
			String namesStr=line.replace("\"","");
			names = Arrays.asList(namesStr.split("\\s*,\\s*"));
			}
		} catch (IOException  e) {
			//e.printStackTrace();
			throw e;
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return buildNamesList(names);
	}
	
	
	private List<Name> buildNamesList(List<String> names){
		
		final AtomicLong counter = new AtomicLong();
		return names.stream().map(fullName-> {
			String[] name=fullName.split(" ");
			if(name.length>1) {
				return new Name(name[0],name[1]);
			}
			else {
				return new Name(name[0],null);
			}
		}).sorted(Comparator.comparing(Name::getFirstName).thenComparing(Name::getLastName,Comparator.nullsFirst(Comparator.naturalOrder()))).map(name->
		{
			name.setOrderNumber(counter.incrementAndGet());		
			return name;
		}).collect(Collectors.toList());
		}
	}	

