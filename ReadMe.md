# Profile Generator

## Introduction
The main reason for developing this tool is to minimize the hassle and time consumption in copy pasting ports for each service from **jenkins** into the **`pom.xml`**.

## Tools & Technologies used
- Java
- Apache Commons
- Apache Maven

## Supported Platforms
- Windows
- Linux
- Mac OS

## Supported Languages
- Java

## Pre Requisites
1. Java
2. Maven

## How to use?
1) Clone this project to your local machine.
2) Copy the whole port list from the jenkins console (Ctrl + C). This will add the copied string to the system clipboard. \
Ex:- 
Please note that the stars`(****)` indicate a service
```
	Mo**** **** ****: 26646
	Mock **** **** ****: 12332
	------------------
	**** **** **** UI: 23490
	**** **** **** Service: 19862
	**** **** **** Server: 29290
	**** **** **** UI: 23330
	**** **** **** Backend: 19072
	------------------
	**** **** **** Service: 13379
	**** **** **** Service: 1206
	**** **** **** Service: 3476
	**** **** **** Service: 18878
	**** **** **** Dashboard: 9294
	**** **** **** Dashboard UI: 1696
	**** **** ****: 5522
	------------------
	**** **** **** Server: 9284
	**** **** **** Server: 12467
	**** **** **** Server: 3308
	**** **** **** Services Port: 21561
```
3) Double click on **`run.bat`**
4) Go to your **`pom.xml`** file and in the profiles section paste the formatted profile (Ctrl + V). This will paste the converted profile in to the **`pom.xml`**
