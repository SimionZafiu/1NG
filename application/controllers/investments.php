<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Investments extends CI_Controller {
	
	public function index()
	{
		
		$this->load->view("dashboard_view");
	}

	public function getInvestments($id)
	{
		$this->load->model("investments_model");
		$getData = $this->investments_model->getInvestments($id);

		foreach ($getData as $customer) {
			
			echo "<br> ".json_encode($customer)."<br> ";

		}
	}

	public function investment($id)
	{
		$this->load->model("investments_model");
		$customer = $this->investments_model->getInvestment($id);
		echo json_encode($customer);
	}
}

/* End of file profile.php */
/* Location: ./application/controllers/profile.php */