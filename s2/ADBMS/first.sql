SET SERVEROUTPUT ON;
DECLARE
    v_number NUMBER := &v_number;  
    v_color  VARCHAR2(20);
BEGIN
    IF v_number = 1 THEN
        v_color := 'Red';
    ELSIF v_number = 2 THEN
        v_color := 'Blue';
    ELSIF v_number = 3 THEN
        v_color := 'Green';
    ELSIF v_number = 4 THEN
        v_color := 'Yellow';
    ELSIF v_number = 5 THEN
        v_color := 'Purple';
    ELSE
        v_color := 'Invalid number';
    END IF;

    DBMS_OUTPUT.PUT_LINE('The color is: ' || v_color);
END;
/




/*

SET SERVEROUTPUT ON;
DECLARE
      
     a integer := &a ; 
     c integer :=1;
 
  BEGIN
  FOR i IN 1..a LOOP
     c := i * c ;
     END LOOP;
  dbms_output.put_line(a||' = '||c);
 
  END;
  /  

*/
