<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Goals extends CI_Controller {
	
	public function index()
	{
		
		$this->load->view("dashboard_view");
	}

    public function getGoals($customerId)
    {
        $this->load->model("goals_model");
        $goals = $this->goals_model->getGoals($customerId);

        foreach ($goals as $goal) {
            
            echo "<br> ".json_encode($goal)."<br> ";

        }
    }

    public function goal($id)
    {
        $this->load->model("goals_model");
        $goal = $this->goals_model->getGoal($id);
        echo json_encode($goal);
    }
}

/* End of file profile.php */
/* Location: ./application/controllers/profile.php */