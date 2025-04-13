DECLARE
    a NUMBER := &a; 
    b NUMBER := &b; 
    v_result VARCHAR2(100);
BEGIN
    update_salary1(a, b, v_result);  
    

    DBMS_OUTPUT.PUT_LINE(v_result);
END;
/

