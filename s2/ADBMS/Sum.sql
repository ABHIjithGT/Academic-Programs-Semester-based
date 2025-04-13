SET SERVEROUTPUT ON;
CREATE OR REPLACE FUNCTION findsum( x in number , y in number )
return number is
	z number;
BEGIN
z:=x+y;
return z;
end findsum;
/

DECLARE
a number(20):=&a;
b number(20):=&b;
c number;
BEGIN
c := findsum(a,b);
dbms_output.put_line('Sum = '||c);
end;
/















