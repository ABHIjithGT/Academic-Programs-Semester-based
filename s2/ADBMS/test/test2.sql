SET SERVEROUTPUT ON;
-- Create a BEFORE INSERT trigger that sets a default salary if not provided
CREATE OR REPLACE TRIGGER before_insert_employee
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN
    -- Set a default salary if not provided
    IF :NEW.salary IS NULL THEN
        :NEW.salary := 40000; -- Default salary
    END IF;
    IF :NEW.employee_name IS NULL THEN
        :NEW.employee_name := 'No name';
    END IF;
    
END;
/
