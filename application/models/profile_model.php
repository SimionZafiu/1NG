<?php
class Profile_model extends CI_Model {    

    function getData($data="no Data")
    {
        $query = $this->db->get('customers', 10);
        return $query->result();
    }

    function getProfile($id = 1)
    {
        $sql = "SELECT * FROM customers as c
        JOIN risk_profile as r ON r.id = c.profile_id
        WHERE c.id = {$id}
        ";
        $query = $this->db->query($sql);
        return $query->result();
    }

}
