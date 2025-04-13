SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE count_employees (
    p_department_id IN NUMBER, 
    p_employee_count OUT NUMBER 
)
IS
BEGIN
    SELECT COUNT(*)
    INTO p_employee_count
    FROM employees
    WHERE department_id = p_department_id;
    
    DBMS_OUTPUT.PUT_LINE('Number of employees in department ' || p_department_id || ' is ' || p_employee_count);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
        p_employee_count := -1; 
END;
/
DECLARE
    v_count NUMBER; 
    id NUMBER;
BEGIN
     id := &department_id; 
    count_employees(p_department_id => id, p_employee_count => v_count);

    DBMS_OUTPUT.PUT_LINE('Employee count: ' || v_count);
END;
/

