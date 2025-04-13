SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION update_salary (
    p_emp_id IN NUMBER,
    p_percentage IN NUMBER
) 
RETURN VARCHAR2
IS
    v_current_salary employees.salary%TYPE;  
    v_new_salary employees.salary%TYPE;      
BEGIN
    SELECT emp_salary 
    INTO v_current_salary
    FROM employee
    WHERE emp_id = p_emp_id;
    v_new_salary := v_current_salary * (1 + p_percentage / 100);
    UPDATE employee
    SET emp_salary = v_new_salary
    WHERE emp_id = p_emp_id;
    COMMIT;
    RETURN 'Salary updated successfully to ' || v_new_salary;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'Employee not found.';
    WHEN OTHERS THEN
        RETURN 'Error occurred: ' || SQLERRM;
END update_salary;
/
 
DECLARE
    a number(20):=&a;
    b number(20):=&b;
    v_result VARCHAR2(100);
BEGIN
    v_result := update_salary(a,b);  
    DBMS_OUTPUT.PUT_LINE(v_result);
END;
/


