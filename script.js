// Get references to the input and the task list
const taskInput = document.getElementById('taskInput');
const taskList = document.getElementById('taskList');

// Function to add a new task
function addTask() {
  const newTask = taskInput.value;
  if (newTask === '') {
    alert('Please enter a task!');
    return;
  }
  const listItem = document.createElement('li');
  listItem.innerHTML = `${newTask} <span class="delete-icon" onclick="deleteTask(this)">❌</span> <span class="complete-icon" onclick="completeTask(this)">✔️</span> <span class="edit-icon" onclick="editTask(this)">✏️</span>`;
  taskList.appendChild(listItem);
  taskInput.value = '';
}

// Event listener for the "Enter" key
taskInput.addEventListener('keyup', function(event) {
  if (event.key === 'Enter') {
    addTask();
  }
});

// Function to delete a task
function deleteTask(item) {
  item.parentNode.remove();
}

// Function to mark a task as complete
function completeTask(item) {
  item.parentNode.style.textDecoration = 'line-through';
}

// Function to edit a task
function editTask(item) {
  const newText = prompt('Edit the task:', item.parentNode.firstChild.textContent);
  if (newText !== null) {
    item.parentNode.firstChild.textContent = newText;
  }
}

// Function to toggle dark mode
function toggleDarkMode() {
  const body = document.body;
  body.classList.toggle('dark-mode');
  const darkModeToggle = document.getElementById('darkModeToggle');
  darkModeToggle.textContent = body.classList.contains('dark-mode') ? '☀️' : '🌙';
}
