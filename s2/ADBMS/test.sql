SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE update_add(
    a IN VARCHAR2,
    d IN NUMBER
)
IS
BEGIN
    UPDATE student
    SET mail = a
    WHERE rollno = d;

    -- Check if any row was updated
    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No record found for Rollno: ' || d);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Mail id updated successfully for Roll no: ' || d);
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/





DECLARE
                           
    v_address VARCHAR2(255);
id number;
BEGIN
                                                  -- Assign the address value to the variable
    v_address := '&v';  
    id := &id;                                    -- You can change this to any address you want
    update_add(v_address, id);                    -- Call the procedure with the address as an argument
    DBMS_OUTPUT.PUT_LINE('Student MAilid updated successfully.');
END;
/
