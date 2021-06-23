delete from company_has_stockexchange
delete from stockprice
delete from ipo
delete from company
delete from stockexchange
delete from sectors




insert into sectors(id,name,description) values(101,'Real Estate','Housing')
insert into sectors(id,name,description) values(102,'FoodNAgro','Food Production')
insert into sectors(id,name,description) values(103,'Telecom','Spring')
insert into sectors(id,name,description) values(104,'Finance','Banks')


insert into stockexchange(id,stockexchangename,brief,contactaddress,remarks) values(201,'NSE','Indian Stock exchange','Mumbai,India','E123654')
insert into stockexchange(id,stockexchangename,brief,contactaddress,remarks) values(202,'BSE','Indian Stock exchange','Mumbai,India','E167238')
insert into stockexchange(id,stockexchangename,brief,contactaddress,remarks) values(203,'NASDAQ','USA stock exchange','New York,USA','S253849')
insert into stockexchange(id,stockexchangename,brief,contactaddress,remarks) values(204,'TYO','Japanese stock exchange','Tokyo, Japan','A562930')

insert into company(id,companyname,turnover,ceo, boardofdirectors,description,sectorname,stockexchangename,companycode,sectors_id) values(301,'Reliance Jio',234400,'Mukesh Ambani','Nita Ambani, Mehul Chaudhary, Rakesh Mehra','India"s largest Mobile Company','Telecom','NSE,BSE',"QW123,QW124",103)
insert into company(id,companyname,turnover,ceo, boardofdirectors,description,sectorname,stockexchangename,companycode,sectors_id) values(302,'DLF LTd',134400,'A','b, c, d','e','Real Estate','','',101)
insert into company(id,companyname,turnover,ceo, boardofdirectors,description,sectorname,stockexchangename,companycode,sectors_id) values(303,'Britannia',434400,'Jeff Marsden','Martin Jacindia, Thomas Guptil, Hiralal Mehta','FoodNAgro Company','Telecom','NSE','RT478',103)
insert into company(id,companyname,turnover,ceo, boardofdirectors,description,sectorname,stockexchangename,companycode,sectors_id) values(304,'Barclays',123400,'Scott James','Mukul Roy, Hamsa Singh, Hiralal Mehta','Finance Company','Finance','NSE','QW342',104)

insert into company_has_stockexchange(id,code,stockexchange_id,company_id) values(601,'QW123',201,301)
insert into company_has_stockexchange(id,code,stockexchange_id,company_id) values(602,'QW341',202,303)
insert into company_has_stockexchange(id,code,stockexchange_id,company_id) values(603,'QW342',201,304)
insert into company_has_stockexchange(id,code,stockexchange_id,company_id) values(604,'RT478',201,303)

insert into ipo(id,price,shares,opendatetime,remarks,companyname,stockexchangename,company_id) values(401,12.3,1400,'12-03-1999 12:23:45','qwerty','Britannia','NSE',303)
insert into ipo(id,price,shares,opendatetime,remarks,companyname,stockexchangename,company_id) values(402,42.4,1500,'12-03-1998 11:34:13','qwert3ry','DLF LTd','BSE',301)
insert into ipo(id,price,shares,opendatetime,remarks,companyname,stockexchangename,company_id) values(403,122.3,1400,'12-03-2009 02:22:50','qazwsxedc','Barclays','NSE',304)

insert into stockprice(id,currentprice,date,time,companycode,stockexchangename, company_id) values(501,123,'12-07-2021','12:43:32','QW342','NSE',304)
insert into stockprice(id,currentprice,date,time,companycode,stockexchangename, company_id) values(502,121,'12-07-2021','12:44:32','QW342','NSE',304)
insert into stockprice(id,currentprice,date,time,companycode,stockexchangename, company_id) values(503,125,'12-07-2021','12:45:32','QW342','NSE',304)
insert into stockprice(id,currentprice,date,time,companycode,stockexchangename, company_id) values(504,122.4,'12-07-2021','12:46:32','QW342','NSE',304)
insert into stockprice(id,currentprice,date,time,companycode,stockexchangename, company_id) values(505,122.6,'13-07-2021','10:43:32','QW341','BSE',303)
insert into stockprice(id,currentprice,date,time,companycode,stockexchangename, company_id) values(506,133.45,'13-07-2021','11:43:32','WE234','NASDAQ',304)

i