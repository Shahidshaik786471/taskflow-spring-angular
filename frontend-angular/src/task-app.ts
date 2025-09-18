export function TaskApp() {
  const wrap = document.createElement('div')
  wrap.innerHTML = `
    <h1>TaskFlow</h1>
    <div>
      <input id="title" placeholder="Title" />
      <input id="assignee" placeholder="Assignee" />
      <select id="status">
        <option>TODO</option><option>DOING</option><option>DONE</option>
      </select>
      <button id="add">Add</button>
    </div>
    <div id="list"></div>
  `
  const list = wrap.querySelector('#list') as HTMLDivElement
  async function load() {
    const res = await fetch('http://localhost:8080/api/tasks')
    const tasks = await res.json()
    list.innerHTML = tasks.map((t:any) => `<div class="card"><b>${t.title}</b> — ${t.status} — ${t.assignee}</div>`).join('')
  }
  wrap.querySelector('#add')!.addEventListener('click', async () => {
    const title = (wrap.querySelector('#title') as HTMLInputElement).value
    const assignee = (wrap.querySelector('#assignee') as HTMLInputElement).value
    const status = (wrap.querySelector('#status') as HTMLSelectElement).value
    await fetch('http://localhost:8080/api/tasks', {
      method: 'POST', headers: {'Content-Type':'application/json'},
      body: JSON.stringify({title, assignee, status})
    })
    load()
  })
  load()
  return wrap
}
