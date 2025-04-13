SET SERVEROUTPUT ON;
CREATE OR REPLACE FUNCTION reverse_string (input_string IN VARCHAR2) 
RETURN VARCHAR2 
IS
    reversed_string VARCHAR2(4000);
    i NUMBER; 
BEGIN
    reversed_string := '';
    FOR i IN REVERSE 1..LENGTH(input_string) LOOP
        reversed_string := reversed_string || SUBSTR(input_string, i, 1);
    END LOOP;
    RETURN reversed_string;
END reverse_string;
/
DECLARE
    original_string VARCHAR2(100) := '&original_string';
    reversed VARCHAR2(100);
BEGIN
    reversed := reverse_string(original_string);
    DBMS_OUTPUT.PUT_LINE('Original String: ' || original_string);
    DBMS_OUTPUT.PUT_LINE('Reversed String: ' || reversed);
END;
/

