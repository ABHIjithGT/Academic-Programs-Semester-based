SET SERVEROUTPUT ON;
CREATE OR REPLACE FUNCTION findmax( x in number , y in number )
return number is
	z number;
BEGIN
if x > y then
	z:=x;
else
 	z:=y;
end if;
return z;
end findmax;
/

DECLARE
a number(20):=&a;
b number(20):=&b;
c number;
BEGIN
c := findmax(a,b);
dbms_output.put_line('the maximum number between ' ||a|| 'and ' ||b|| ' is '||c);
end;
/
